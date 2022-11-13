import React from 'react';
import { useState, useRef } from 'react';

import styles from './landing.module.scss';
import logo from '../../images/logo.svg';
import alpha from '../../images/alpha.svg';
import moneybag from '../../images/moneybag.svg';
import stonks from '../../images/stonks.svg';
import coat from '../../images/coat.svg';
import scroll from '../../images/scroll.svg';
import stream from '../../images/stream.png';
import avatar from '../../images/popcat.png';
import ad from '../../images/ad.png';

const Landing = (): JSX.Element => {
    const [isDonateOption, setOption] = useState(true);
    const streamPreview = useRef<HTMLHeadingElement>(null);

    const scrollToStream = () => {
        streamPreview.current?.scrollIntoView({behavior: 'smooth'});
    }

    return (<div className={styles.Wrapper}>
        <header className={styles.Topbar}>
            <a href="" className={styles.Logo}>
                <img className={styles.Letter} src={logo} alt="" />
                <img className={styles.Alpha} src={alpha} alt="" />
            </a>
            <div className={styles.Menu}>
                <a className={styles.MenuBtn} href="#">Главная</a>
                <a className={styles.MenuBtn} href="#">О нас</a>
                <button className={styles.SignIn}>Вход</button>
            </div>
        </header>
        <div className={styles.Wrapper}>
            <div className={styles.Banner} style={{backgroundImage: `url(${ad})`}}>
                <div className={styles.MainText}>Alfa Donate - с нами проще</div>
                <button className={styles.Join}>Начать использовать</button>
            </div>
            <div className={styles.Benefits}>
                <div className={styles.Benefit}>
                    <img className={styles.Icon} src={moneybag} alt="" />
                    <p className={styles.Description}>Создание сборов</p>
                </div>
                <div className={styles.Benefit}>
                    <img className={styles.Icon} src={stonks} alt="" />
                    <p className={styles.Description}>Аналитика платежей</p>
                </div>
                <div className={styles.Benefit}>
                    <img className={styles.Icon} src={coat} alt="" />
                    <p className={styles.Description}>Независимый сервис</p>
                </div>
            </div>
            <div className={styles.Features}>
                <div className={styles.Advertise} onClick={scrollToStream}>
                    <h2 className={styles.Title}>Возможности сервиса</h2>
                    <img className={styles.Scroll} src={scroll}/>
                </div>
                <div className={styles.Buttons}>
                    <button className={styles.Btn} onClick={() => {setOption(true)}}>Платные сообщения</button>
                    <button className={styles.Btn} onClick={() => {setOption(false)}}>Сбор средств</button>
                </div>
                <h2 ref={streamPreview} className={styles.MsgFromUsers}>
                    {isDonateOption ? 
                        'Получайте сообщения от зрителей'
                        :
                        'Устраивайте сборы на великие цели'
                    }
                </h2>
                <div className={styles.Stream} style={{backgroundImage: `url(${stream})`}}>
                    <div className={styles.Donater}>
                        <div className={styles.Avatar} style={{backgroundImage: `url(${avatar})`}}></div>
                        <div className={styles.Sender}>Tom Soer - 100 rub</div>
                        <div className={styles.Message}>Спасибо за стрим!</div>
                    </div>
                    <div className={styles.Progress}>
                        <div className={styles.Bar}>
                            {
                                isDonateOption ? '' : 
                                (<div>
                                    <div className={styles.Percentages} style={{background: `linear-gradient(to right, #C8281D 0%,#C8281D 68%,#fff 68%)`}}>
                                    На мечту
                                </div>
                                68%
                                </div>
                                )
                            }
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>);
}

export default Landing;