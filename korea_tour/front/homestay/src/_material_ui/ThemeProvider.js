import React from "react";
import { ThemeProvider,createMuiTheme } from "@material-ui/core/styles";


const GlobalTheme = createMuiTheme({
    palette: {
      primary: {
          main: "#f16664",
        },
      secondary: {
            main: "#fff6e6",
          },
      error: {
            main: "#79cccd",
          },
      info: {
            main: "#6bb7b9",
          },
      success: {
            main: "#007b8c",
        },
    },
  });


export const GlobalThemeProvider = ({ children }) => (
    <ThemeProvider theme={GlobalTheme}>{children}</ThemeProvider>
  );

