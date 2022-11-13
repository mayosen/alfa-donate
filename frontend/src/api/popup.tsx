export interface IDonate {
    nickname: string;
    amount: number;
    message: string;
}

export interface IFund {
    collected: number;
    aim: number;
}