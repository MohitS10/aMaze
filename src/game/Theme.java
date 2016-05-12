package game;

import java.awt.Color;

public class Theme {
	private static Color ThemeWhite[] = {Color.WHITE,Color.WHITE};
	private static Color ThemeBlack[] = {Color.BLACK,Color.BLACK};
	private static Color ThemePlayer[] = {Color.BLUE,Color.PINK};
	private static Color ThemeTreasure[] = {Color.YELLOW,Color.GREEN};
	private static Color ThemeEnemy[] = {Color.RED,Color.YELLOW};
	
	public static int currentTheme;
	
	public Theme() {
		setCurrentTheme(1);
	}
	
	public static int getCurrentTheme() {
		return currentTheme;
	}
	
	public static void setCurrentTheme(int currentTheme) {
		Theme.currentTheme = currentTheme;
	}
	
	public static Color getThemeBlack() {
		return ThemeBlack[currentTheme];
	}
	
	public static Color getThemeWhite() {
		return ThemeWhite[currentTheme];
	}
	
	public static Color getThemePlayer() {
		return ThemePlayer[currentTheme];
	}
	
	public static Color getThemeTreasure() {
		return ThemeTreasure[currentTheme];
	}
	
	public static Color getThemeEnemy() {
		return ThemeEnemy[currentTheme];
	}
}