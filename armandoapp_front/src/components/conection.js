
import React from "react";
import Avatar from "@mui/material/Avatar";
import Typography from "@mui/material/Typography";
import ImageList from "@mui/material/ImageList";
import ImageListItem from "@mui/material/ImageListItem";
import ImageListItemBar from "@mui/material/ImageListItemBar";





const conection = function () {
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

     const itemData = [
       {
         img: "https://images.unsplash.com/photo-1551963831-b3b1ca40c98e",
         title: "Breakfast",
         author: "@bkristastucchio",
       },
       {
         img: "https://images.unsplash.com/photo-1551782450-a2132b4ba21d",
         title: "Burger",
         author: "@rollelflex_graphy726",
       },
       {
         img: "https://images.unsplash.com/photo-1522770179533-24471fcdba45",
         title: "Camera",
         author: "@helloimnik",
       },
       {
         img: "https://images.unsplash.com/photo-1444418776041-9c7e33cc5a9c",
         title: "Coffee",
         author: "@nolanissac",
       },
       {
         img: "https://images.unsplash.com/photo-1533827432537-70133748f5c8",
         title: "Hats",
         author: "@hjrc33",
       },
       {
         img: "https://images.unsplash.com/photo-1558642452-9d2a7deb7f62",
         title: "Honey",
         author: "@arwinneil",
       },
       {
         img: "https://images.unsplash.com/photo-1516802273409-68526ee1bdd6",
         title: "Basketball",
         author: "@tjdragotta",
       },
       {
         img: "https://images.unsplash.com/photo-1518756131217-31eb79b20e8f",
         title: "Fern",
         author: "@katie_wasserman",
       },
       {
         img: "https://images.unsplash.com/photo-1597645587822-e99fa5d45d25",
         title: "Mushrooms",
         author: "@silverdalex",
       },
       {
         img: "https://images.unsplash.com/photo-1567306301408-9b74779a11af",
         title: "Tomato basil",
         author: "@shelleypauls",
       },
       {
         img: "https://images.unsplash.com/photo-1471357674240-e1a485acb3e1",
         title: "Sea star",
         author: "@peterlaster",
       },
       {
         img: "https://images.unsplash.com/photo-1589118949245-7d38baf380d6",
         title: "Bike",
         author: "@southside_customs",
       },
     ];
     

    return (
      <div>
        <Avatar
          sx={{ width: 200, height: 200, top: "50%", left: "35%" }}
          alt="Remy Sharp"
          src="/img/cruz.jpg"
        />
        <Typography
          variant="h3"
          component="div"
          gutterBottom
          sx={{ top: "20%", display: "inline" }}
        >
          Daniel Porras
        </Typography>
        <Typography
          sx={{ display: "inline" }}
          component="span"
          variant="body2"
          color="text.primary"
        ></Typography>
        {"           ——— Descripcion"}
        <p>
          es explicar, de manera detallada y ordenada, cómo son las personas,
          animales, lugares, objetos, etc. La descripción sirve sobre todo para
          ambientar la acción y crear una que haga más creíbles los hechos que
          se narran. Muchas veces, contribuyen a detener la acción y preparar el
          escenario de los hechos que siguen.
        </p>
        <ImageList sx={{ width: 500, height: 450 }} className="center">
          {itemData.map((item) => (
            <ImageListItem key={item.img}>
              <img
                src={`${item.img}?w=248&fit=crop&auto=format`}
                srcSet={`${item.img}?w=248&fit=crop&auto=format&dpr=2 2x`}
                alt={item.title}
                loading="lazy"
              />
              <ImageListItemBar
                title={item.title}
                subtitle={<span>by: {item.author}</span>}
                position="below"
              />
            </ImageListItem>
          ))}
        </ImageList>
      </div>
    );

}

export default conection;