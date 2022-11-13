import React from 'react';
import { useState } from 'react';
import { Widget, widgetProps } from '../Widget/Widget';
import { IDonate, IFund } from '../../api/popup';

const Blank = (): JSX.Element => {

    let userToken = "09c41e6d-3c35-492f-8f85-8d009d27ee61"
    let donateSource = new EventSource(`http://localhost:8080/donate/${userToken}`)
    let fundSource = new EventSource(`http://localhost:8080/fund/${userToken}`)

    let donateQueue: IDonate[] = [];
    let fundQueue: IFund[] = [];

    const [popUps, show] = useState<IDonate[]>([]);

    donateSource.addEventListener('donate', event => {
        let donate = JSON.parse(event.data)
        donateQueue.push(donate)
    });
  
    fundSource.addEventListener('fundUpdate', event => {
        let fund = JSON.parse(event.data)
        fundQueue.push(fund)
    });

    function showDonate() {
        let donate = donateQueue[0];
        donateQueue.shift();
        if (donate === undefined) {
            return;
        }
        popUps.push(donate);
        show(popUps);
    }
  
    function updateFund() {
        let fund = fundQueue[0];
        fundQueue.shift();
        if (fund === undefined) {
            return;
        }
        popUps.shift();
        show(popUps);
    }

    let donateTimer = setInterval(showDonate, 1000)
    let fundTimer = setInterval(updateFund, 1000)
  
    return (<div>
        {popUps.map((props) => {
            return <Widget {...props}></Widget>
        })}
    </div>);
}

export default Blank;