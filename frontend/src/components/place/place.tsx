import React from 'react';
import { useState, useRef } from 'react';

import styles from './place.module.scss';
import first from '../../images/first.svg';
import second from '../../images/second.svg';
import third from '../../images/third.svg';

type PlaceProps = {
    nickname: string;
    place: number;
}

const places: { [key: number]: string }  = {
    1: first,
    2: second,
    3: third
}

export function Place(props: PlaceProps): JSX.Element {
    return (
        <div className={styles.Wrapper}>
            <div className={styles.Donater}>{props.nickname}</div>
            <img src={places[props.place]} className={styles.Place}/>
        </div>
    );
}