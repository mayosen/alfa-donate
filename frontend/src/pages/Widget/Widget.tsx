import React from 'react';
import styles from '../widget/widget.module.scss';

type widgetProps = {
    image?: string;
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
            <div className={styles.Image}>{image}</div>
            <div className={styles.UserName}>{userName} - {valueMoney}</div>
            <div className={styles.Text}>{text}</div>
        </div>
    );
}
