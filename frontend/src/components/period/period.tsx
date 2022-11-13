import React from 'react';
import { useState, useRef } from 'react';

import styles from './period.module.scss';
import first from '../../images/first.svg';
import second from '../../images/second.svg';
import third from '../../images/third.svg';

type PeriodProps = {
    period: string,
    amount: number;
}

export function Period(props: PeriodProps): JSX.Element {
    return (
        <div className={styles.Wrapper}>
            <div className={styles.Period}>{props.period}</div>
            <div className={styles.Amount}>{props.amount}</div>
        </div>
    );
}