export interface IDonate {
    nickname: string;
    amount: number;
    message: string;
    id: number;
    date: number;
    tag: string;
    destroyTime: NodeJS.Timer;
}

export interface IFund {
    collected: number;
    aim: number;
}