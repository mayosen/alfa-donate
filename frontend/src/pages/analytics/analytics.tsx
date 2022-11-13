import React from 'react';
import { useState, useRef } from 'react';

import styles from './analytics.module.scss';
import logo from '../../images/logo.svg';

import { Chatdonate } from '../../components/chatdonate/chatdonate';
import { Place } from '../../components/place/place';
import { Period }from '../../components/period/period';


const Analytics = (): JSX.Element => {
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
                        <select className={styles.Selector} name="" id="">
                            <option className={styles.Option} value="week">За неделю</option>
                            <option className={styles.Option} value="month">За месяц</option>
                            <option className={styles.Option} value="year">За год</option>
                        </select>
                    </div>
                </div>
                <div className={styles.List}>
                    <Period period="Март" amount={2000}></Period>
                    <Period period="Март" amount={2000}></Period>
                    <Period period="Март" amount={2000}></Period>
                    <Period period="Март" amount={2000}></Period>
                    <Period period="Март" amount={2000}></Period>
                    <Period period="Март" amount={2000}></Period>
                    <Period period="Март" amount={2000}></Period>
                    <Period period="Март" amount={2000}></Period>
                    <Period period="Март" amount={2000}></Period>
                    <Period period="Апрель" amount={2000}></Period>
                    <Period period="Апрель" amount={2000}></Period>
                </div>
            </div>
            <div className={styles.Top}>
                <h2 className={styles.Title}>Топ донатеров</h2>
                <div className={styles.Rating}>
                    <Place nickname='first' place={1}></Place>
                    <Place nickname='second' place={2}></Place>
                    <Place nickname='third' place={3}></Place>
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
                <Chatdonate nickname={"Anton"} amount={200} commentary={"Спасибо"}></Chatdonate>
                <Chatdonate nickname={"Anton"} amount={200} commentary={"Спасибо за детство"}></Chatdonate>
                <Chatdonate nickname={"Anton"} amount={200} commentary={"kk"}></Chatdonate>
                <Chatdonate nickname={"Anton"} amount={200} commentary={"Спасибо"}></Chatdonate>
                <Chatdonate nickname={"Anton"} amount={200} commentary={"Спасибо"}></Chatdonate>
                <Chatdonate nickname={"Anton"} amount={200} commentary={"Спасибо"}></Chatdonate>
                <Chatdonate nickname={"Not Anton"} amount={200} commentary={"Спасибо"}></Chatdonate>
            </div>
        </div>
    </div>
}

export default Analytics;