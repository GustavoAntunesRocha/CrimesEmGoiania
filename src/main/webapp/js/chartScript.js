var chartData = [ {
    "country": "GO-CENTRAL",
    "crimes": 4252
  }, {
    "country": "GO-SUDESTE",
    "crimes": 1882
  }, {
    "country": "GO-NORTE",
    "crimes": 1809
  }, {
    "country": "GO-NORTE",
    "crimes": 1322
  }, {
    "country": "GO-SUDOESTE",
    "crimes": 1122
  }, {
    "country": "GO-OESTE",
    "crimes": 1114
  }, {
    "country": "GO-NOROESTE",
    "crimes": 984
  }
  ];

AmCharts.makeChart( "chartdiv", {
	  "type": "serial",
	  "dataProvider": chartData,
	  "categoryField": "country",
	  "graphs": [ {
		    "valueField": "crimes",
		    "type": "column"
	  } ]
});