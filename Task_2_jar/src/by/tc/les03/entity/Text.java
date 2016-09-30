package by.tc.les03.entity;

public class Text {
	private String text;

	public Text() {
		text = "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Text other = (Text) obj;
		if (text == null) {
			if (other.text != null) {
				return false;
			}
		} else if (!text.equals(other.text)) {
			return false;
		}
		return true;
	}
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Text.class.getSimpleName());
		sb.append(": <text = ");
		sb.append(text);
		sb.append(">.");
		return sb.toString();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
