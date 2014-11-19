public class Program {
	public static void main(String[] args) throws Exception {
		UserValidator userValidator = new UserValidator();
		userValidator.validateUser();

		calendarValidator calendarValidator = new calendarValidator();
		calendarValidator.validateCalendar();

		groupValidator groupValidator = new groupValidator();
		groupValidator.validateGroup();

		EventValidator eventValidator = new EventValidator();
		eventValidator.validateEvent();
	}
}
