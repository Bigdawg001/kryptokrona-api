const getArrayData = (length) => {
  return Array.from({length: length}, () => Math.floor(Math.random() * length));
}

export let chart1 = {
  data: [
    {
      data: [30, 40, 35, 50, 49, 60, 70, 91, 125]
    }
  ],
  name: "chart1",
};
export let chart2 = {
  data:[
    {
      data: [10, 41, 35, 51, 49, 62, 69, 91, 148]
    }
  ],
  name: "chart2",
};
export let chart3 = {
  data:  [
    {
      data: [55, 41, 35, 65, 49, 62, 69, 110, 130] 
    } 
  ],
  name: "chart3",
};
export let chart4 = {
  data: [
    {
      data: [35, 31, 45, 45, 19, 22, 39, 10, 15] 
    } 
  ],
  name: "chart4",
};

export let chart5 = {
  data: [
    {
      data: [44, 55, 57, 56, 61, 58, 63, 60, 66],
    },
    {
      data: [76, 85, 101, 98, 87, 105, 91, 114, 94],
    },
  ],
  name: "chart5",
};

export let chart6 = {
  data: [
    {
      data: getArrayData(10)
    },
    {
      data: getArrayData(10)
    },
    {
      data: getArrayData(10)
    }
  ],
  name: "chart6",
};
export let chart7 = {
  data: [
    {
      data: getArrayData(10),
      name: "Swepool"
    },
    {
      data: getArrayData(10),
      name: "Göta Pool"
    },
    {
      data: getArrayData(10),
      name: "Blocksum"
    }
  ],
  name: "chart7"
}

export let chart8 = {
  data: [
    {
      data: getArrayData(10),
      name: "Swepool"
    },
    {
      data: getArrayData(10),
      name: "Göta Pool"
    },
    {
      data: getArrayData(10),
      name: "Göta Pool"
    }
  ],
  name: "chart8"
}

export let months = ["jan","feb","mars","apr","may","jun","jul","aug","sep","okt","nov","dec"];

export let nodes = [
  {
    "name": "Göta Pool",
    "url": "gota.kryptokrona.se",
    "port": 11898,
    "ssl": false,
    "cache": false,
    "version": "1.1.1",
    "fee": "0.00",
    "proxy_url": "gota",
},
{
    "name": "Blocksum",
    "url": "blocksum.org",
    "port": 11898,
    "ssl": false,
    "cache": false,
    "version": "1.1.1",
    "fee": "0.00",
    "proxy_url": "blocksum",
},
{
    "name": "Swepool",
    "url": "swepool.org",
    "port": 11898,
    "ssl": false,
    "cache": false,
    "version": "1.1.1",
    "fee": "0.00",
    "proxy_url": "swepool",
},
]
