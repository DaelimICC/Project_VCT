import re

regex_Email = re.compile(r'^([A-Za-z0-9]+[.-_])*[A-Za-z0-9]+@[A-Za-z0-9-]+(\.[A-Z|a-z]{2,})+$')
# password = 대문자,특수문자,숫자를 포함한 8-18글자
regex_Password = re.compile(r'^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!#%*?&]{8,18}$')
regex_Nick = re.compile(r'^[가-힣a-zA-Z]+[가-힣a-zA-Z0-9]{1,9}$')
regex_Phone = re.compile(r'^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$')


def validUser(validdata):
    errors_detail = []
    if re.match(regex_Email, validdata['email']):
        pass
    else:
        errors_detail.append('Email Invalid')

    if re.match(regex_Password, validdata['password']):
        pass
    else:
        errors_detail.append('Password Invalid')

    if re.match(regex_Nick, validdata['nick']):
        pass
    else:
        errors_detail.append('Nick Invalid')

    if re.match(regex_Phone, validdata['phone']):
        pass
    else:
        errors_detail.append('Phone Invalid')

    return errors_detail
