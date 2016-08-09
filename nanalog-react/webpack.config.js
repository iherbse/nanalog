var webpack = require('webpack');
var ExtractTextPlugin = require('extract-text-webpack-plugin');

module.exports = {
    devtool: 'inline-source-map',
    entry: [
        'webpack-hot-middleware/client',
        'webpack/hot/only-dev-server', // "only" prevents reload on syntax errors
        './client/client.js',
        './semantic/dist/semantic'
    ],
    output: {
        path: require('path').resolve("./dist"),
        filename: 'bundle.js',
        publicPath: '/'
    },
    plugins: [
        new webpack.optimize.OccurrenceOrderPlugin(),
        new webpack.HotModuleReplacementPlugin(),
        new webpack.NoErrorsPlugin(),
        new ExtractTextPlugin("styles.css"),
        new webpack.ProvidePlugin({
           $: "jquery",
           jQuery: "jquery"
       })

    ],
    module: {
        loaders: [{
            test: /\.js$/,
            loader: 'babel-loader',
            exclude: /node_modules/,
            query: {
                presets: ['react', 'es2015']
            }
        }, {
            test: /\.css$/,
            loader: ExtractTextPlugin.extract('style-loader', 'css-loader')
        },
        {
                test: /\.(eot|svg|ttf|woff|woff2)$/,
                loader: 'file?name=public/fonts/[name].[ext]'
            },
            {
    test: /\.png$/,
    loader: "url-loader",
    query: { mimetype: "image/png" }
},
{ test: require.resolve("jquery"), loader: "imports?jQuery=jquery" }

      ]
    }
}
