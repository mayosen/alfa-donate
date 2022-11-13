export interface IDonate {
    nickname: string;
    amount: number;
    message: string;
    id: number;
    date: number;
    tag: string;
}

export interface IFund {
    collected: number;
    aim: number;
}