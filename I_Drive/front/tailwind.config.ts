import type { Config } from 'tailwindcss'

export default <Config>{
  content: [
    "./components/**/*.{vue,js,ts}",
    "./layouts/**/*.{vue,js,ts}",
    "./pages/**/*.{vue,js,ts}",
    "./app.vue",
    "./plugins/**/*.{js,ts}"
  ],
  theme: {
    extend: {
      colors: {
        primary: "#000000",
        purple: '#9700ff',
        secondary: "#2F4858",
        accent: "#743973",
        white: "#fffeff",
        purpleDark: "#4f4577",
        blueDark: "#33496b",
        blueGray: "#304858",
        grayLight: "#D9D9D9",
        gold: "#deb822",
        greenDark: "#457753",
        greenBright: "#43de2a",
        redBright: "#ee2639",
        black: "#1e1e1e",
        redDark: "#A91B3A"
      }
    }
  },
  plugins: []
}
