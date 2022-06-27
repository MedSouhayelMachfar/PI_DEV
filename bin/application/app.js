const express=require('express');
const ejs= require('ejs');
const multer=require('multer');
const path=require('path');


const app=express();

app.set('view engine','ejs');

app.use('/public',express.static(path.join(__dirname,'src')));

const storage=multer.diskStorage({
    destination: path.join(__dirname,'src','uploads'),
    filename: (req,file,callBack)=>{
        callBack(null,`${file.filename}-${Date.now()}${path.extname(file.originalname)}`);

    }
})



const upload=multer({
    storage:storage,
    fileFilter: (req,file,callBack)=>{

        const prExt=/jpg|jpeg|png|gif/;
        const checkExt=prExt.test(path.extname(file.originalname));
        const checkmime=prExt.test(file.mimetype);


        if(checkExt && checkmime){
            callBack(null,true);
        }else{
            callBack('image seulement!!');
        }
    }
}).single('avatar');

app.post('/upload',(req,res)=>{
    upload(req,res,err=>{
        if(err){
            res.render('index',{
                error : err
            })
        }else {
            if(req.file !== undefined){
                res.render('index',{
                    file : req.file.filename
                })
            }else{
                res.render('index',{
                    error: 'champ vide'
                })
            }
        }
    })
})


app.get('/',(req,res)=> res.render('index'));


const PORT= process.env.PORT || 5000;


app.listen(PORT, ()=> console.log(`le serveur s'execute sur la porte ${PORT}`));
