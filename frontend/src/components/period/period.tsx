import React from 'react';
import { useState, useRef } from 'react';

import styles from './period.module.scss';
import first from '../../images/first.svg';
import second from '../../images/second.svg';
import third from '../../images/third.svg';

type PeriodProps = {
    dateTime: number,
    amount: number;
    period: string;
}

const monthNames = ["Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
  "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
];

const daysNames = [
    "Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"
]

export function Period(props: PeriodProps): JSX.Element {
    let dateString: string;
    const date = new Date(props.dateTime);
    if (props.period == 'month') {
        dateString = monthNames[date.getMonth()];
    } else {
        dateString = daysNames[date.getMonth()];
    }
    return (
        <div className={styles.Wrapper}>
            <div className={styles.Period}>{dateString}</div>
            <div className={styles.Amount}>{props.amount}</div>
        </div>
    );
}