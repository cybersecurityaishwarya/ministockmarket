package com.stock.DataTransferObject;

import java.util.List;

//has identical fields as the python api 
public record StockResponse (String Ticker, Double Live_Price, List <HistoricalData> History)

{}
