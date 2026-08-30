package com.stock.DataTransferObject;

public record TrendingStock(String symbol, String companyName,Double marketPrice,Double marketChange, Double marketChangePercent)

{}
