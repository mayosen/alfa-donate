import React from 'react';
import { useState } from 'react';
import { Widget, widgetProps } from '../Widget/Widget';
import { IDonate, IFund } from '../../api/popup';
import img from '../../images/popcat.png';
import { clear } from '@testing-library/user-event/dist/clear';
import { Collect } from '../Collect/Colllect';

const BlankFund = (): JSX.Element => {

    let userToken = "09c41e6d-3c35-492f-8f85-8d009d27ee61"
    let fundSource = new EventSource(`http://localhost:8080/fund/${userToken}`)

    let fundQueue: IFund[] = [];

    const [popUps, show] = useState<IFund[]>([]);
    const [sum, setSum] = useState(0);
    fundSource.addEventListener('fundUpdate', event => {
        let fund = JSON.parse(event.data)
        setSum(sum + fund.aim)
        fundQueue.push(fund)
    });

    function showDonate() {
        let fund = fundQueue[0];
        fundQueue.shift();
        if (fund === undefined) {
            return;
        }
        popUps.push(fund);
        show([...popUps]);
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

    let donateTimer = setInterval(showDonate, 10000)
    let fundTimer = setInterval(updateFund, 10000)
    
    return (<div>
        {<Collect
            value={sum}
            totalValue={600}
            text='На мечту'
        />}
    </div>);
}

export default BlankFund;