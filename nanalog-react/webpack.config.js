var webpack = require('webpack');

module.exports={
  devtool:'inline-source-map',
  entry:[
    'webpack-hot-middleware/client',
    'webpack/hot/only-dev-server', // "only" prevents reload on syntax errors
    './client/client.js'
  ],
  output:{
    path: require('path').resolve("./dist"),
    filename: 'bundle.js',
    publicPath: '/'
  },
  plugins:[
    new webpack.optimize.OccurrenceOrderPlugin(),
    new webpack.HotModuleReplacementPlugin(),
    new webpack.NoErrorsPlugin()
  ],
  module:{
    loaders:[
      {
        test:/\.js$/,
        loader: 'babel-loader',
        exclude:/node_modules/,
        query:{
          presets:['react','es2015']
        }
      }
    ]
  }
}
