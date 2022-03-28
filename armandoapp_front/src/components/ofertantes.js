import React, { useEffect, useState } from "react";
import ReactDOM from 'react-dom';
import List from "@mui/material/List";
import ListItem from '@mui/material/ListItem';
import Avatar from "@mui/material/Avatar";
import ListItemAvatar from "@mui/material/ListItemAvatar";
import ListItemText from "@mui/material/ListItemText";
import Typography from "@mui/material/Typography";
import ListItemButton from "@mui/material/ListItemButton"
import '../styles/Ofertantes.css'


const Ofertantes = function() {
    const [data, setData] = useState(null);
    const [reload, setReload] = useState('reload');
    let g = "sdasd"
    let lista = function () {

    }

    useEffect(() => {
        alert("entre")
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


    let listaJxc = function (props) {

        return (<List sx={{ width: "100%", maxWidth: 360, bgcolor: "background.paper" }} >
            <ListItemButton onClick={() => { console.log(props.username) }}>
                <ListItem alignItems="flex-start">
                    <ListItemAvatar>
                        <Avatar
                            alt={props.username}
                            src="/img/cruz.jpg"
                            sx={{ width: 56, height: 56 }}
                        />
                    </ListItemAvatar>
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
                </ListItem>
            </ListItemButton>
        </List>);

    }


    return (
        <div className="container" >
            <h1> CARPINTERIA </h1>
            {ofertas()}
        </div>
  );
}

export default Ofertantes;
