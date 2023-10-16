
import React from "react";
import { Line } from "react-chartjs-2";



const LineChart = (props) => {
  const userMaxArray = props.data;

  const labels = []
  let benchMax = userMaxArray.map(b => b.bench);
  let pullupMax = userMaxArray.map(b => b.pullups);

  let squadMax = userMaxArray.map(b => b.squad);
  let deadliftMax = userMaxArray.map(b => b.deadlift);

  userMaxArray.forEach(element => {
    labels.push(element.dayOfRecords)
  });
  const data = {
    labels: labels,
    datasets: [
      {
        label: "Bench Max",
        backgroundColor: "rgb(255, 0, 0)",
        borderColor: "rgb(255, 0, 0)",
        data: benchMax,
      },
      {
        label: "Pullups Max",
        backgroundColor: "rgb(0,0,255)",
        borderColor: "rgb(0,0,255)",
        data: pullupMax,
      },
      {
        label: "Squad Max",
        backgroundColor: "rgb(255,255,0)",
        borderColor: "rgb(255,255,0)",
        data: squadMax,
      },
      {
        label: "Deadlift Max",
        backgroundColor: "rgb(0,100,0)",
        borderColor: "rgb(0,100,0)",
        data: deadliftMax,
      },
    ],
  };
  // white
  const options = {
    scales: {
      x: {
        grid: {
          color: "black",
        },
        ticks: {
          color: "#black",
          font: {
            size: 30,
            family: "Bangers",

          },

        },
      },
      y: {
        grid: {

          color: "black",
        },
        ticks: {
          color: "#black",
          font: {
            size: 34,
            family: "Bangers",

          },

        },
      },
    },
    plugins: {
      legend: {
        labels: {
          color: "#black",
          font: {
            size: 30,
            family: "Bangers",
            border: "2px solid black"

          },
        },

      },
    },
  };

  return (
    <div className="diagram-div">
      <Line data={data} options={options} />
    </div>
  );
};

export default LineChart;