# You need to set-up Twilio beforehand
# Also you need to pip install 'six', 'requests', 'pytz'
# SMS capabilities do not work in Bulgaria, this code is just an example of a cool thing you can do with Python

from twilio.rest import Client

# Your Account SID from twilio.com/console
account_sid = "my_account_sid"
# Your Auth Token from twilio.com/console
auth_token  = "my_account_token"

client = Client(account_sid, auth_token)

message = client.messages.create(
    to="to_number", 
    from_="from_number",
    body="My name is Ronnnn.")

print(message.sid)
