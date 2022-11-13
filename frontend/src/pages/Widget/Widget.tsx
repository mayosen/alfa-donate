import React from 'react';
import styles from './Widget.module.scss';

export type widgetProps = {
    image: string;
    nickname: string;
    amount: number;
    message: string;
};

export function Widget({
    image,
    nickname: userName,
    amount: valueMoney,
    message,
}: widgetProps): JSX.Element {
    return (
        <div className={styles.Main}>
            <img
                className={styles.Image}
                src={image}
                alt=""
            />
            <div className={styles.UserName}>{userName} - {valueMoney}</div>
            <div className={styles.Text}>{message}</div>
        </div>
    );
}
