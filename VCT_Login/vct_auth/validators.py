import re
from rest_framework.exceptions import ValidationError

regex_Email = re.compile(r'^([A-Za-z0-9]+[.-_])*[A-Za-z0-9]+@[A-Za-z0-9-]+(\.[A-Z|a-z]{2,})+$')
# password = 대문자,특수문자,숫자를 포함한 8-18글자
regex_Password = re.compile(r'^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!#%*?&]{8,18}$')
regex_Nick = re.compile(r'^[가-힣a-zA-Z]+[가-힣a-zA-Z0-9]{1,9}$')
regex_Phone = re.compile(r'^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$')


def valid_email(email):
    if re.match(regex_Email, email):
        pass
    else:
        raise ValidationError('Email Invalid')


def valid_password(password):
    if re.match(regex_Password, password):
        pass
    else:
        raise ValidationError('Password Invalid')


def valid_nick(nick):
    if re.match(regex_Nick, nick):
        pass
    else:
        raise ValidationError('Nick Invalid')


def valid_phone(phone):
    if re.match(regex_Phone, phone):
        pass
    else:
        raise ValidationError('Phone Invalid')

