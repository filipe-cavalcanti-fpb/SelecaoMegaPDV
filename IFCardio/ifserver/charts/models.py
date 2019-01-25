from django.db import models

class Paragraph(models.Model):
    paragraph = models.TextField()

    def __str__(self):
        return self.paragraph[:50]+"..."

class Examn(models.Model):
    examn_title = models.TextField(max_length=50)
    examn_content = models.ManyToManyField(Paragraph)

    def __unicode__(self):
        return self.examn_title

    def __str__(self):
        return self.examn_title

    def get_title(self):
        return self.examn_title