# Нагрузочное тестирование

## Запрос put
### wrk

Параметры запуска

```
./wrk -t4 -c64 -d40s -R8000 -s put.lua --latency http://127.0.0.1:8080

```

Полученный результат

```
Running 40s test @ http://127.0.0.1:8080
  4 threads and 16 connections
  Thread calibration: mean lat.: 272.757ms, rate sampling interval: 914ms
  Thread calibration: mean lat.: 279.187ms, rate sampling interval: 920ms
  Thread calibration: mean lat.: 278.823ms, rate sampling interval: 923ms
  Thread calibration: mean lat.: 284.978ms, rate sampling interval: 943ms
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     8.76ms   14.29ms  76.61ms   86.67%
    Req/Sec     2.00k    33.33     2.13k    79.53%
  Latency Distribution (HdrHistogram - Recorded Latency)
 50.000%    2.36ms
 75.000%    6.79ms
 90.000%   30.80ms
 99.000%   61.09ms
 99.900%   69.12ms
 99.990%   75.01ms
 99.999%   76.42ms
100.000%   76.67ms

  Detailed Percentile spectrum:
       Value   Percentile   TotalCount 1/(1-Percentile)

       0.112     0.000000            1         1.00
       1.104     0.100000        24038         1.11
       1.431     0.200000        48045         1.25
       1.720     0.300000        72019         1.43
       2.015     0.400000        95934         1.67
       2.361     0.500000       120014         2.00
       2.579     0.550000       131983         2.22
       2.869     0.600000       143925         2.50
       3.317     0.650000       155922         2.86
       4.279     0.700000       167884         3.33
       6.791     0.750000       179884         4.00
       8.775     0.775000       185893         4.44
      11.311     0.800000       191878         5.00
      15.023     0.825000       197872         5.71
      19.055     0.850000       203870         6.67
      25.679     0.875000       209859         8.00
      28.447     0.887500       212871         8.89
      30.799     0.900000       215861        10.00
      33.791     0.912500       218871        11.43
      37.439     0.925000       221850        13.33
      41.151     0.937500       224854        16.00
      43.391     0.943750       226361        17.78
      45.599     0.950000       227851        20.00
      48.095     0.956250       229345        22.86
      50.655     0.962500       230860        26.67
      52.991     0.968750       232348        32.00
      54.175     0.971875       233095        35.56
      55.071     0.975000       233853        40.00
      56.095     0.978125       234606        45.71
      57.151     0.981250       235342        53.33
      58.495     0.984375       236103        64.00
      59.103     0.985938       236467        71.11
      59.807     0.987500       236841        80.00
      60.639     0.989062       237211        91.43
      61.343     0.990625       237588       106.67
      62.207     0.992188       237969       128.00
      62.783     0.992969       238147       142.22
      63.391     0.993750       238345       160.00
      63.935     0.994531       238527       182.86
      64.575     0.995313       238709       213.33
      65.343     0.996094       238910       256.00
      65.727     0.996484       238991       284.44
      66.175     0.996875       239097       320.00
      66.623     0.997266       239186       365.71
      67.135     0.997656       239271       426.67
      67.647     0.998047       239370       512.00
      67.903     0.998242       239413       568.89
      68.223     0.998437       239475       640.00
      68.479     0.998633       239512       731.43
      68.799     0.998828       239555       853.33
      69.183     0.999023       239599      1024.00
      69.503     0.999121       239625      1137.78
      69.951     0.999219       239646      1280.00
      70.335     0.999316       239674      1462.86
      70.655     0.999414       239704      1706.67
      70.911     0.999512       239721      2048.00
      71.039     0.999561       239729      2275.56
      71.167     0.999609       239741      2560.00
      71.423     0.999658       239752      2925.71
      71.615     0.999707       239763      3413.33
      72.255     0.999756       239775      4096.00
      72.575     0.999780       239781      4551.11
      72.831     0.999805       239787      5120.00
      73.215     0.999829       239793      5851.43
      73.663     0.999854       239799      6826.67
      74.175     0.999878       239804      8192.00
      74.879     0.999890       239808      9102.22
      75.135     0.999902       239810     10240.00
      75.391     0.999915       239814     11702.86
      75.583     0.999927       239816     13653.33
      75.839     0.999939       239819     16384.00
      75.903     0.999945       239821     18204.44
      75.967     0.999951       239822     20480.00
      76.095     0.999957       239824     23405.71
      76.159     0.999963       239825     27306.67
      76.223     0.999969       239826     32768.00
      76.287     0.999973       239828     36408.89
      76.287     0.999976       239828     40960.00
      76.287     0.999979       239828     46811.43
      76.351     0.999982       239829     54613.33
      76.415     0.999985       239831     65536.00
      76.415     0.999986       239831     72817.78
      76.415     0.999988       239831     81920.00
      76.415     0.999989       239831     93622.86
      76.415     0.999991       239831    109226.67
      76.607     0.999992       239832    131072.00
      76.607     0.999993       239832    145635.56
      76.607     0.999994       239832    163840.00
      76.607     0.999995       239832    187245.71
      76.607     0.999995       239832    218453.33
      76.671     0.999996       239833    262144.00
      76.671     1.000000       239833          inf
#[Mean    =        8.756, StdDeviation   =       14.285]
#[Max     =       76.608, Total count    =       239833]
#[Buckets =           27, SubBuckets     =         2048]
----------------------------------------------------------
  319922 requests in 40.00s, 25.32MB read
Requests/sec:   7998.13
Transfer/sec:    648.29KB
```

По сравнению с предидущим этапом цифры не сильно изменились. По всей видимости для пут запросов не составляет больщой задержки пересылка от ноды к ноде

### Async-profiler 
![alt text](https://raw.githubusercontent.com/IvanovAndrey/2020-highload-dht/7de7c5b5e02915df36607d0ed761ff786d57e7ef/async/put_cpu_s.svg)

Так же видим воркеры и селекторы, отношение друг к другу у них не изменилось. В глаза брасается, что 17 процентов ресура процессора занимают пересылки между нодами.
Так же 15 процентов это посылка ответа и 26 - непосредственно работа библиотеки RocksDB.

### Allocation
![alt text](https://raw.githubusercontent.com/IvanovAndrey/2020-highload-dht/7de7c5b5e02915df36607d0ed761ff786d57e7ef/async/put_alloc_s.svg)

Тут так же видны пересылки (функция forwardRequest) выше которых идут invoke средствами one nio.

### Lock
![alt text](https://raw.githubusercontent.com/IvanovAndrey/2020-highload-dht/7de7c5b5e02915df36607d0ed761ff786d57e7ef/async/put_lock_s.svg)

Локи присутствуют, почти все возникают во время SelectorThread.

## Запрос get
### wrk

Параметры запуска

```
/wrk -t4 -c16 -d40s -R8000 -s get.lua --latency http://127.0.0.1:8080

```

Полученный результат

```
Running 40s test @ http://127.0.0.1:8080
  4 threads and 16 connections
  Thread calibration: mean lat.: 67.605ms, rate sampling interval: 464ms
  Thread calibration: mean lat.: 69.359ms, rate sampling interval: 475ms
  Thread calibration: mean lat.: 61.095ms, rate sampling interval: 424ms
  Thread calibration: mean lat.: 62.437ms, rate sampling interval: 436ms
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    49.14ms  109.15ms 524.03ms   88.33%
    Req/Sec     2.00k   171.99     2.51k    80.00%
  Latency Distribution (HdrHistogram - Recorded Latency)
 50.000%    2.41ms
 75.000%   23.23ms
 90.000%  197.38ms
 99.000%  478.46ms
 99.900%  510.98ms
 99.990%  520.45ms
 99.999%  524.03ms
100.000%  524.29ms

  Detailed Percentile spectrum:
       Value   Percentile   TotalCount 1/(1-Percentile)

       0.109     0.000000            1         1.00
       0.994     0.100000        23978         1.11
       1.318     0.200000        48001         1.25
       1.619     0.300000        71919         1.43
       1.959     0.400000        95901         1.67
       2.413     0.500000       119891         2.00
       2.769     0.550000       131868         2.22
       3.503     0.600000       143830         2.50
       8.003     0.650000       155800         2.86
      14.767     0.700000       167785         3.33
      23.231     0.750000       179769         4.00
      29.519     0.775000       185762         4.44
      40.543     0.800000       191760         5.00
      57.663     0.825000       197750         5.71
      91.839     0.850000       203747         6.67
     135.423     0.875000       209737         8.00
     168.447     0.887500       212733         8.89
     197.375     0.900000       215721        10.00
     230.527     0.912500       218725        11.43
     260.863     0.925000       221714        13.33
     290.303     0.937500       224712        16.00
     313.855     0.943750       226222        17.78
     341.759     0.950000       227718        20.00
     368.639     0.956250       229206        22.86
     395.519     0.962500       230708        26.67
     419.583     0.968750       232214        32.00
     430.335     0.971875       232957        35.56
     440.319     0.975000       233708        40.00
     449.023     0.978125       234449        45.71
     456.191     0.981250       235203        53.33
     463.103     0.984375       235960        64.00
     467.199     0.985938       236328        71.11
     472.063     0.987500       236698        80.00
     476.159     0.989062       237073        91.43
     479.999     0.990625       237448       106.67
     485.119     0.992188       237838       128.00
     487.423     0.992969       238013       142.22
     489.471     0.993750       238192       160.00
     492.287     0.994531       238387       182.86
     495.359     0.995313       238570       213.33
     498.175     0.996094       238758       256.00
     499.711     0.996484       238854       284.44
     501.247     0.996875       238952       320.00
     502.527     0.997266       239036       365.71
     504.063     0.997656       239137       426.67
     505.599     0.998047       239223       512.00
     506.623     0.998242       239278       568.89
     507.647     0.998437       239329       640.00
     508.927     0.998633       239370       731.43
     509.951     0.998828       239412       853.33
     510.975     0.999023       239461      1024.00
     511.487     0.999121       239480      1137.78
     512.511     0.999219       239513      1280.00
     513.023     0.999316       239529      1462.86
     513.791     0.999414       239550      1706.67
     514.559     0.999512       239578      2048.00
     514.815     0.999561       239585      2275.56
     515.327     0.999609       239598      2560.00
     515.839     0.999658       239610      2925.71
     516.607     0.999707       239624      3413.33
     517.375     0.999756       239633      4096.00
     517.887     0.999780       239639      4551.11
     518.399     0.999805       239645      5120.00
     518.911     0.999829       239652      5851.43
     519.423     0.999854       239656      6826.67
     519.935     0.999878       239662      8192.00
     520.191     0.999890       239664      9102.22
     520.703     0.999902       239669     10240.00
     521.215     0.999915       239671     11702.86
     521.727     0.999927       239674     13653.33
     522.239     0.999939       239680     16384.00
     522.239     0.999945       239680     18204.44
     522.239     0.999951       239680     20480.00
     522.239     0.999957       239680     23405.71
     523.007     0.999963       239683     27306.67
     523.007     0.999969       239683     32768.00
     523.519     0.999973       239684     36408.89
     523.775     0.999976       239685     40960.00
     523.775     0.999979       239685     46811.43
     524.031     0.999982       239688     54613.33
     524.031     0.999985       239688     65536.00
     524.031     0.999986       239688     72817.78
     524.031     0.999988       239688     81920.00
     524.031     0.999989       239688     93622.86
     524.031     0.999991       239688    109226.67
     524.287     0.999992       239690    131072.00
     524.287     1.000000       239690          inf
#[Mean    =       49.144, StdDeviation   =      109.149]
#[Max     =      524.032, Total count    =       239690]
#[Buckets =           27, SubBuckets     =         2048]
----------------------------------------------------------
  319783 requests in 40.00s, 25.27MB read
Requests/sec:   7994.68
Transfer/sec:    646.93KB
```

Вот здесь уже видна существенная просадка по производительности. У масштабирования есть своя цена. Но в глобальном плане если еще чуть снизить нагрузку
цифры будут адеватными.

### Async-profiler 
![alt text](https://raw.githubusercontent.com/IvanovAndrey/2020-highload-dht/7de7c5b5e02915df36607d0ed761ff786d57e7ef/async/get_cpu_s.svg)

Точно так же видны пересылки как в запросах выше и работа с самими запросами как в предидущих этапах.

### Allocation
![alt text](https://raw.githubusercontent.com/IvanovAndrey/2020-highload-dht/7de7c5b5e02915df36607d0ed761ff786d57e7ef/async/get_alloc_s.svg)

### Lock
![alt text](https://raw.githubusercontent.com/IvanovAndrey/2020-highload-dht/7de7c5b5e02915df36607d0ed761ff786d57e7ef/async/get_lock_s.svg)

С памятью и локами картина похожа на запросы пут. 

Общие выводы - на графиках четко видны пересылки между нодами, которые занимают ощутимую часть ресурсов, но не стал бы называть эту часть критичной. 
