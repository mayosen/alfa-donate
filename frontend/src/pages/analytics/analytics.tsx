import React from 'react';
import { useState, useRef } from 'react';

import styles from './analytics.module.scss';
import logo from '../../images/logo.svg';


const Analytics = (): JSX.Element => {
    return <div className={styles.Wrapper}>
        <div className={styles.MainInfo}>
            <div className={styles.Balance}>
                <h2 className={styles.Title}>Баланс</h2>
                <div className={styles.Money}>15000</div>
            </div>
            <div className={styles.Donates}></div>
            <div className={styles.Top}></div>
            <div className={styles.Soon}></div>
        </div>
        <div className={styles.Chat}>
            <div className={styles.Header}>
                <img className={styles.Logo} src={logo} alt="" />
                <div className={styles.LogoText}>ALFA Donate</div>
            </div>
        </div>
    </div>
}

export default Analytics;