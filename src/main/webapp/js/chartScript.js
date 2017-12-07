var chartData = [ {
    "country": "CENTRAL",
    "crimes": 4252
  }, {
    "country": "SUDESTE",
    "crimes": 1882
  }, {
    "country": "NORTE",
    "crimes": 1809
  }, {
    "country": "NORTE",
    "crimes": 1322
  }, {
    "country": "SUDOESTE",
    "crimes": 1122
  }, {
    "country": "OESTE",
    "crimes": 1114
  }, {
    "country": "NOROESTE",
    "crimes": 984
  }
  ];

AmCharts.makeChart( "chartdiv", {
	  "type": "serial",
	  "dataProvider": CrimeDao.crimeToJson(),
	  "categoryField": "country",
	  "graphs": [ {
		    "valueField": "crimes",
		    "type": "column"
	  } ]
});