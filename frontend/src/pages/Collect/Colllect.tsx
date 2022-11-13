import React from 'react';

import styles from './Collect.module.scss';

type collectProps = {
    value: number;
    totalValue: number;
    text?: string;
};

export function Collect({
    value,
    totalValue,
    text,
}: collectProps): JSX.Element {
    return (
        <div className={styles.Main}>
            <div className={styles.Card}>
                <div className={styles.Text}>{text}</div>
                <div style={{width: `${value ? value/totalValue*100+1 : 0}%`}} className={styles.Progress}></div>
            </div>
            <div className={styles.Procent}>{(value/totalValue*100).toFixed()} %</div>
        </div>
    );
}
