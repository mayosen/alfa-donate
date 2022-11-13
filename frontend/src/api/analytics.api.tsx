import { AxiosResponse } from 'axios';
import {AxiosInstance} from './axiosinstance';

export interface IDonater {
    nickname: string;
    sum: number;
}

export interface ITimeDonate {
    amount: number;
    dateTime: number;
}

export class AnalyticsAPIs {
    async getTopDonaters(): Promise<AxiosResponse<IDonater[]>> {
        return await AxiosInstance.get<IDonater[]>(
            '/analytics/top-donaters'
        );
    }

    async getTimeStatistics(id: number, param: string): Promise<AxiosResponse<ITimeDonate[]>> {
        return await AxiosInstance.get<ITimeDonate[]>(
            `/analytics/by-date/${id}?groupBy=${param}`
        );
    }
}


export const analyticsAPIs = new AnalyticsAPIs();
