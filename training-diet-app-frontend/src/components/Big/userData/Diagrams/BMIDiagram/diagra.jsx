import React, { useEffect, useState } from 'react';

const Diagram = (props) => {
    const { weight, height } = props.data;

    useEffect(() => {
        function placeUserValues() {
            const chart = document.getElementById('chart');

            if (!chart) {
                console.error('Chart element not found.');
                return;
            }

            let ysum = (((height) - 1.43) / 0.57) * 374;
            ysum = Math.abs(ysum - 374);
            let yMark = ysum + chart.offsetTop + 37;

            let xsum = (((weight) - 36) / 88) * 734;
            let xMark = xsum + chart.offsetLeft + 32;
            yMark = yMark - 11;
            xMark = xMark - 11;

            let x = document.getElementById('x');

            x.style.position = "absolute";
            x.style.top = yMark + "px";
            x.style.left = xMark + "px";
            x.style.fontSize = "20px";
            x.style.fontWeight = "bold";
            x.style.display = "inline-block";
        }

        placeUserValues();

    }, []);

    return (
        <div>
            <div id="graphic-container">
                <img id="chart" src="https://upload.wikimedia.org/wikipedia/commons/c/cc/BMI_chart.png" alt="BMI chart" width="800px" />
                <span id="x">&#10060;</span>
            </div>
        </div>
    );
}

export default Diagram;
