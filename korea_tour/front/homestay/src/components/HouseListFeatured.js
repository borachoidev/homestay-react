import React from "react";
import Grid from "@material-ui/core/Grid";
import HouseListSort from "./HouseListSort";
import HouseCard from "./HouseCard";
import NavBar from "./NavBar";
import Pagination from "./Pagination";
import CssBaseline from "@material-ui/core/CssBaseline";
import Container from "@material-ui/core/Container";

export default function HouseListFeatured() {
  return (
    //여기에 for문 img src = url
    <Grid container spacing={3}>
      <Grid item xs={12}>
        <HouseListSort />
      </Grid>
      <Grid item xs={12} sm={6}>
        <HouseCard url="https://source.unsplash.com/featured/?travel" />
      </Grid>
      <Grid item xs={12} sm={6}>
        <HouseCard url="https://source.unsplash.com/featured/?nature" />
      </Grid>
      <Grid item xs={6} sm={4} md={3}>
        <HouseCard url="https://source.unsplash.com/featured/?city" />
      </Grid>
      <Grid item xs={6} sm={4} md={3}>
        <HouseCard url="https://source.unsplash.com/featured/?forest" />
      </Grid>
      <Grid item xs={6} sm={4} md={3}>
        <HouseCard url="https://source.unsplash.com/featured/?mountains" />
      </Grid>
      <Grid item xs={6} sm={4} md={3}>
        <HouseCard url="https://source.unsplash.com/featured/?island" />
      </Grid>
    </Grid>
    
  );
}