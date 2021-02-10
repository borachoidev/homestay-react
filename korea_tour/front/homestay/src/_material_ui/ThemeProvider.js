import React from "react";
import { ThemeProvider,createMuiTheme } from "@material-ui/core/styles";


const GlobalTheme = createMuiTheme({
    palette: {
      primary: {
          main: "#f16664",
        },
      secondary: {
            main: "#00A699",
          },
      Arches: {
            main: "#FC642D",
            },
      Hof:{
            main: "#484848"
        },
      info:{
          main: "#fff6e6"
      },
    },
   
  });


export const GlobalThemeProvider = ({ children }) => (
    <ThemeProvider theme={GlobalTheme}>{children}</ThemeProvider>
  );

