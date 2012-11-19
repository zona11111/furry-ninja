package model;

public class Skates {

	private int countSkates;
	private int c1;
	private int c2;
	private int c3;
	private int cnt1;
	private int cnt2;
	private int cnt3;

	public Skates() {
		init();
	}

	private void init() {

	}

	public int getCountSkates() {
		return countSkates;
	}

	public void setCountSkates(int countSkates) {
		this.countSkates = countSkates;
		recount();
	}

	private void recount() {
		c1 = 0;
		c2 = 0;
		c3 = 0;
		cnt1 = countSkates / 3;
		cnt2 = (countSkates - cnt1) / 2;
		cnt3 = countSkates - cnt1 - cnt2;
	}

	public boolean getSkatesBySize(int size) {
		if (size == 1) {
			if (c1 < cnt1) {
				c1++;
				return true;
			}
		} else {
			if (size == 2) {
				if (c2 < cnt2) {
					c2++;
					return true;
				}
			} else {
				if (size == 3) {
					if (c3 < cnt3) {
						c3++;
						return true;
					}
				} else {
					return false;
				}
			}
		}
		return false;
	}

	public void returnSkatesBySize(int size) {
		if (size == 1) {
			c1--;
		}
		if (size == 2) {
			c2--;
		}
		if (size == 3) {
			c3--;
		}
		return;
	}

	public boolean peekSkatesBySize(int shoeSize) {
		// TODO Auto-generated method stub
		if (shoeSize == 1) {
			if (c1 < cnt1) {
				return true;
			}
		} else {
			if (shoeSize == 2) {
				if (c2 < cnt2) {
					return true;
				}
			} else {
				if (c3 < cnt3) {
					return true;
				}
			}
		}
		return false;
	}

}
