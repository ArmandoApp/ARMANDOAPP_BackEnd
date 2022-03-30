import React, { useEffect, useState} from "react";

import List from "@mui/material/List";
import ListItem from '@mui/material/ListItem';
import Avatar from "@mui/material/Avatar";
import ListItemAvatar from "@mui/material/ListItemAvatar";
import ListItemText from "@mui/material/ListItemText";
import Typography from "@mui/material/Typography";
import ListItemButton from "@mui/material/ListItemButton";
import Box from "@mui/material/Box";
import Modal from "@mui/material/Modal";
import Button from "@mui/material/Button";
import ButtonGroup from "@mui/material/ButtonGroup";
import Stack from "@mui/material/Stack";


import Conection from './conection';


import '../styles/Ofertantes.css'
import { Navigate } from "react-router-dom";


const Ofertantes = function() {
    const style = {
      position: "absolute",
      top: "50%",
      left: "50%",
      transform: "translate(-50%, -50%)",
      width: 400,
      bgcolor: "background.paper",
      border: "2px solid #000",
      boxShadow: 24,
      pt: 2,
      px: 4,
      pb: 3,
    };
    const [data, setData] = useState(null);
    const [open, setOpen] = useState(false);
    const handleOpen = () => {
      setOpen(true);
    };
    const handleClose = () => {
      setOpen(false);
    };
    useEffect(() => {
        
        fetch("http://localhost:8080/v1/Armando/Categorias/getCategories/Carpinteria")
            .then(response => response.json())
            .then(data => {
                setData(data)
            })
    }, []);


    let ofertas = function () {
        let jcx = []
        if (data != null) {
            for (let i = 0; i < data.length; i++) {
                jcx.push(listaJxc(data[i]))
            }

            return jcx
        }   

    }

    let modal = function(){
        console.log("entre")
    
       
         return (
           <Modal
             hideBackdrop
             open={open}
             onClose={handleClose}
             aria-labelledby="child-modal-title"
             aria-describedby="child-modal-description"
           >
             <Box sx={{ ...style, width: 800, height: 900 }}>
               <Conection />
               <br></br>
               <br></br>
               <footer className="center">
                 <Stack spacing={2} direction="row" className="center">
                   <Button variant="contained" onClick={handleClose}>Volver</Button>
                   <Button variant="outlined">Contactar</Button>
                 </Stack>
               </footer>
             </Box>
           </Modal>
         );
        
        
    }


    let listaJxc = function (props) {

        return (
            
          <List
            sx={{
              width: "100%",
              maxWidth: 500,
              bgcolor: "background.paper",
              borderRadius: 10,
              display: "block",
            }}
          >
            <ListItemButton onClick={handleOpen} sx={{ borderRadius: 10 }}>
              
              <ListItem alignItems="flex-start">
                <ListItemAvatar>
                  <Avatar
                    className="avatar"
                    alt={props.username}
                    src="/img/cruz.jpg"
                    sx={{ width: 56, height: 56 }}
                  />
                </ListItemAvatar>
                <div className="center">
                  <ListItemText
                    primary={props.username}
                    secondary={
                      <React.Fragment>
                        <Typography
                          sx={{ display: "inline" }}
                          component="span"
                          variant="body2"
                          color="text.primary"
                        >
                          {props.category}
                        </Typography>
                        {" — Listo para trabajar"}
                      </React.Fragment>
                    }
                  />
                </div>
              </ListItem>
            </ListItemButton>
          </List>
        );

    }


    return (
      <div className="center">
        <h1 className="center"> CARPINTERIA </h1>
        <div className="center">{ofertas()}</div>
        <div> {modal()} </div>
      </div>
    );
}

export default Ofertantes;
