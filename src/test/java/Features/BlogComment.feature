@blog_comment_form
Feature: Blog Comment Test
Scenario: Test leave a comment on blog
Given user is already on blog form
Then Pop up is going ready to be closed
Then user close the coupon popup
Then Pop up is closed
Then user enter comment on blog form
Then user enter captcha on blog form
Then user click on Submit button on blog form

