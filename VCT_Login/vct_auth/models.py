from django.db import models
from django.contrib.auth.models import AbstractBaseUser, BaseUserManager


class UserManager(BaseUserManager):
    def create_user(self, email, password, nick, phone):
        if not email:
            raise ValueError("Email must not be empty")
        if not password:
            raise ValueError("Password must not be empty")
        if not nick:
            raise ValueError("Nick must not be empty")
        if not phone:
            raise ValueError("Phone must not be empty")

        user = self.model(
            email=self.normalize_email(email),
            nick=nick,
            phone=phone
        )
        user.set_password(password)
        user.save(using=self._db)
        return user


class User(AbstractBaseUser):
    email = models.EmailField(max_length=50, unique=True)
    nick = models.CharField(max_length=50, unique=True)
    phone = models.CharField(max_length=20, unique=True)
    is_active = models.BooleanField(default=True)
    refresh_token = models.CharField(max_length=500, null=True)

    USERNAME_FIELD = 'email'

    objects = UserManager()

    def __str__(self):
        return self.email

