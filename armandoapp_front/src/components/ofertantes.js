import React from "react";
import List from "@mui/material/List";
import ListItem from '@mui/material/ListItem';
import Avatar from "@mui/material/Avatar";
import ListItemAvatar from "@mui/material/ListItemAvatar";
import ListItemText from "@mui/material/ListItemText";
import Typography from "@mui/material/Typography";
import '../styles/Ofertantes.css'


const Ofertantes = function() {


    let ofertas = function(text){
        
        return( <List sx={{ width: "100%", maxWidth: 360, bgcolor: "background.paper" }} >
            <ListItem alignItems="flex-start">
            <ListItemAvatar>
                <Avatar
                alt="Remy Sharp"
                src="/img/cruz.jpg"
                sx={{ width: 56, height: 56 }}
                />
            </ListItemAvatar>
            <ListItemText
                primary= {text}
                secondary={
                <React.Fragment>
                    <Typography
                    sx={{ display: "inline" }}
                    component="span"
                    variant="body2"
                    color="text.primary"
                    >
                    Ali Connors
                    </Typography>
                    {" — I'll be in your neighborhood doing errands this…"}
                </React.Fragment>
                }
            />
            </ListItem>
        </List>);
    }


    
    return (
        <div className="container">
            {ofertas("")}
        </div>
  );
}

export default Ofertantes;
