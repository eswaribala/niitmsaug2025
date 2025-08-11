from django.db import models

# Create your models here.
class Customer(models.Model):
    first_name = models.CharField(max_length=100)
    last_name = models.CharField(max_length=100)
    email = models.EmailField(unique=True)
    phone = models.CharField(max_length=15, blank=True)
    account_no = models.IntegerField(primary_key=True)
    password = models.CharField(max_length=10)
    created_at = models.DateTimeField(auto_now_add=True)
    def __str__(self):
        return f"{self.first_name} {self.last_name}, {self.email}, {self.phone}, {self.account_no}, {self.created_at}"


class Address(models.Model):
    addressId = models.AutoField(primary_key=True)
    door_no=models.CharField(max_length=5)
    street = models.CharField(max_length=100)
    city = models.CharField(max_length=100)
    state = models.CharField(max_length=100)
    zip_code = models.CharField(max_length=10)
    customer = models.ForeignKey(Customer, on_delete=models.CASCADE, related_name='addresses')
    def __str__(self):
        return f"{self.door_no}, {self.street}, {self.city}, {self.state}, {self.zip_code}, {self.customer}"

class Gender(models.TextChoices):
    MALE = 'M'
    FEMALE = 'F'
    OTHER = 'O'

class CompanyType(models.TextChoices):
    PRIVATE = 'P'
    PUBLIC = 'U'
    GOVERNMENT = 'G'

class Individual(Customer):
    gender = models.TextField(
        choices=Gender.choices,
        default=Gender.MALE
    )
    date_of_birth = models.DateField()
    def __str__(self):
        return f"{self.first_name} {self.last_name}, {self.email}, {self.phone}, {self.account_no}, {self.created_at}, {self.gender}, {self.date_of_birth}"
    
class Corporate(Customer):

    company_type = models.TextField(
        choices=CompanyType.choices,
        default=CompanyType.PRIVATE
    )
    def __str__(self):
        return f"{self.first_name} {self.last_name}, {self.email}, {self.phone}, {self.account_no}, {self.created_at}, {self.company_name}, {self.company_type}"
