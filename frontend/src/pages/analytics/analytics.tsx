import React from 'react';
import { useState, useEffect } from 'react';

import styles from './analytics.module.scss';
import logo from '../../images/logo.svg';

import { Chatdonate } from '../../components/chatdonate/chatdonate';
import { Place } from '../../components/place/place';
import { Period }from '../../components/period/period';

import { analyticsAPIs } from '../../api/analytics.api';
import { IDonater, ITimeDonate } from '../../api/analytics.api';


const Analytics = (): JSX.Element => {

    const [donaters, setDonaters] = useState<IDonater[]>();
    const [timestat, setTimeStat] = useState<ITimeDonate[]>();
    const [bytime, setBy] = useState('month');

    useEffect(() => {
        const request = async () => {
            const res = await analyticsAPIs.getTopDonaters();
            if (res.status === 200) {
                setDonaters(res.data);
            }
        };

        request();

        const requestDate = async () => {
            const res = await analyticsAPIs.getTimeStatistics(bytime);
            if (res.status === 200) {
                setTimeStat(res.data);
            }
        };

        requestDate();
    }, []);

    const handleChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
        setBy(event.target.value);
    };


    return <div className={styles.Wrapper}>
        <div className={styles.MainInfo}>
            <div className={styles.Balance}>
                <h2 className={styles.Title}>Баланс</h2>
                <div className={styles.Money}>15000</div>
            </div>
            <div className={styles.Donates}>
                <div className={styles.Header}>
                    <h2 className={styles.Title}>Донаты</h2>
                    <div className={styles.SelectorBox}>
                        Временной отрезок:
                        <select className={styles.Selector} name="" id="" onChange={(event) => {handleChange(event)}}>
                            <option className={styles.Option} value="month">За месяц</option>
                            <option className={styles.Option} value="day">За неделю</option>
                        </select>
                    </div>
                </div>
                <div className={styles.List}>
                    {timestat && timestat.map((item) => {
                        return (<Period {...item} period={bytime} key={item.amount}></Period>)
                    })}
                </div>
            </div>
            <div className={styles.Top}>
                <h2 className={styles.Title}>Топ донатеров</h2>
                <div className={styles.Rating}>
                    {donaters && donaters.map((el, ind) => {
                        return <Place nickname={el.nickname} place={ind+1}></Place>
                    })}
                </div>
            </div>
            <div className={styles.Soon}>
                скоро
            </div>
        </div>
        <div className={styles.Chat}>
            <div className={styles.Header}>
                <img className={styles.Logo} src={logo} alt="" />
                <div className={styles.LogoText}>ALFA Donate</div>
            </div>
            <div className={styles.Messages}>
            </div>
        </div>
    </div>
}

export default Analytics;