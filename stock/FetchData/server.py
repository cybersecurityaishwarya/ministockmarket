from contextlib import asynccontextmanager

from fastapi import FastAPI, HTTPException
import requests
import yfinance as yf
import yahooquery as yq
from yahooquery import Ticker
import json
import uvicorn
import time
import asyncio
def get_trending_data():
   trending=yq.get_trending()
   symbols=[stock['symbol'] for stock in trending["quotes"]]
   stocks=Ticker(symbols)
   quotes=stocks.price
   result=[]
   for ticker in symbols:
       data=quotes.get(ticker,{})
       company_name=(
           data.get("longName") or data.get("shortName") or ticker
       )
       result.append({
                "symbol":ticker,
                "companyName":company_name,
                "marketPrice":round(data.get("regularMarketPrice"),2),
                "marketChange":round(data.get("regularMarketChange"),2),
                "marketChangePercent":round(data.get("regularMarketChangePercent")*100,2),
            })
   return result

# @app.get("/api/stock/trending")

def watch_trending_stocks():
    prev_data= None

    while True:
        current_data=get_trending_data()
        if current_data!=prev_data:
            requests.post("http://localhost:8080/api/stock/trending", json=current_data)
            print("Trending stocks updated ")
            prev_data=current_data
        time.sleep(180)
@asynccontextmanager
async def lifespan(app:FastAPI):
    watcher=asyncio.create_task(asyncio.to_thread(watch_trending_stocks))
    yield
    watcher.cancel()
    
app=FastAPI(lifespan=lifespan)
@app.get("/api/stock/trending")
def get_trending_stocks():
    return get_trending_data()

@app.get("/api/stock/{ticker}")
def get_stock_history(ticker:str):
    try:
        stock_object=yf.Ticker(ticker.upper())
        
        data=stock_object.history(period="1y",interval="1d")
        if data.empty:

            raise HTTPException(status_code=404,detail="Stock not found")
        live_stock_price=stock_object.fast_info.last_price
        data=data[['Open','High','Low','Close','Volume']].reset_index()
        data['Date']=data['Date'].dt.strftime('%Y-%m-%d')
        
        return{
            "Ticker": ticker.upper(),
            "Live_Price": live_stock_price,
            "History": json.loads(data.to_json(orient="records") )}
    
    except Exception as e:
        raise HTTPException(status_code=500,detail=str(e))


if __name__=="__main__":
    uvicorn.run(app, host="127.0.0.1", port=8000)


# @app.get("/stock/{ticker}")
# async def get_stock_data(ticker: str):
#     data = yf.download(tickers=ticker, period="1mo", interval="1d", multi_level_index=False)
#     if data.empty:
#         raise HTTPException(status_code=404, detail="Stock not found")
#     return data[['Open','High','Low','Close', 'Volume']]