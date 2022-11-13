import React from 'react';
import { useState, useRef } from 'react';

import styles from './chatdonate.module.scss';

type ChatdonateProps = {
    nickname: string;
    amount: number;
    commentary: string;
}

export function Chatdonate(props: ChatdonateProps): JSX.Element {
    return (
        <div className={styles.Wrapper}>
            <div className={styles.Donater}>{`${props.nickname} - ${props.amount}₽`}</div>
            <div className={styles.Message}>{`${props.commentary}`}</div>
        </div>
    );
}