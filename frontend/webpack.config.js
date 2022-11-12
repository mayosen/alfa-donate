import webpack from 'webpack';
import path from 'path';
import { dirname } from 'path';
import {fileURLToPath} from 'url';
import HtmlWebpackPlugin from 'html-webpack-plugin';

const __filename = fileURLToPath(import.meta.url);
const __dirname = dirname(__filename);

const config =  {
    mode: 'development',
    entry: './src/index.tsx',
    module: {
      rules: [
        {
          test: /\.(ts|tsx)?$/,
          use: 'ts-loader',
          exclude: /node_modules/,
        },
        {
          test: /\.(js|jsx)?$/,
          use: 'babel-loader',
          exclude: /node_modules/,
        },
        {
          test: /\.(css|scss)?$/,
          use: ["style-loader", "css-loader"],
          exclude: /node_modules/,
        },
        {
          test: /\.(jpg|jpeg|png|gif|mp3)$/,
          use: [ {
            loader: "file-loader"
          }],
        },
        {
          test: /\.svg$/,
          use: [
              {
                  loader: 'svg-url-loader',
              },
          ],
        },
      ],
    },
    resolve: {
      extensions: ['.tsx', '.ts', '.js', '.css', '.scss'],
    },
    output: {
      publicPath: '/'
    },
    plugins: [
        new HtmlWebpackPlugin({
        template: 'public/index.html',
      }),
    ],
    devServer: {
      historyApiFallback: true,
      allowedHosts: 'all',
      static: {
          directory: path.join(__dirname, 'dist/'),
      },
      devMiddleware: {
          publicPath: 'http://localhost:5001/',
      },
      client: {
          overlay: false,
      },
      hot: true,
      port: 5001,
      open: true,
      headers: {
          'Access-Control-Allow-Origin': '*',
          'Access-Control-Allow-Headers':
              'Origin, X-Requested-With, Content-Type, Accept',
      },
  },
}

export default config;