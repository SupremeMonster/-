module.exports={
entry:__dirname+"/app/main.js",

output:{
	path:__dirname+"/public/javascripts",
    filename:"bundle.js"
    },
  
 module: {//�������ļ������css loader
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