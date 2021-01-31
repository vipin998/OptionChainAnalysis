package com.option.chain.analysis.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptionTimeSeries {

    private double callOI;
    private double callChngInOI;
    private double callVolume;
    private double callIV;
    private double callLTP;
    private double callNetChng;
    private double callBidQty;
    private double callBidPrice;
    private double callAskPrice;
    private double callAskQty;
    private double strikePrice;
    private double putBidQty;
    private double putBidPrice;
    private double putAskPrice;
    private double putAskQty;
    private double putNetChng;
    private double putLTP;
    private double putIV;
    private double putVolume;
    private double putChngInOI;
    private double putOI;
    private double roc;


}
