module.exports={
entry:__dirname+"/app/main.js",

output:{
	path:__dirname+"/public/javascripts",
    filename:"bundle.js"
    },
  
 module: {//在配置文件里添加css loader
    loaders: [
      {
        test: /\.css$/,
        loader: "css"
      },
	   { 
	   test: /\.less$/, 
	   loader: 'style!css!less?sourceMap'},
    ]
  },
}