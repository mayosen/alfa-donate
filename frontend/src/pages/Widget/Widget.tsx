import React from 'react';
import styles from './Widget.module.scss';

type widgetProps = {
    image: string;
    userName: string;
    valueMoney: number;
    text: string;
};

export function Widget({
    image,
    userName,
    valueMoney,
    text,
}: widgetProps): JSX.Element {
    return (
        <div className={styles.Main}>
            <img
                className={styles.Image}
                src={image}
                alt=""
            />
            <div className={styles.UserName}>{userName} - {valueMoney}</div>
            <div className={styles.Text}>{text}</div>
        </div>
    );
}
