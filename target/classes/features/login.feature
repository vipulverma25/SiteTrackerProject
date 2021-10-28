Feature: Automating Site Tracker

	@selenium
	Scenario: Login and navigate to datatable and edit details of third record
		Given login to homepage
		And click on COMPONENT_REFERENCE tab
		And search in QuickFind for datatable
		And select in line edit option from elements dropdown and run